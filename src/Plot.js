import React, { Fragment } from 'react';
import { ResponsiveHeatMap } from '@nivo/heatmap';
import { data } from './plot-data';
import Modal from 'react-modal';
import './Plot.css';
import axios from 'axios';

export default class Plot extends React.Component {
    state = {
        data: [],
        hoverTarget: "cell",
        modalIsOpen: false,
        selectedCell: null,
        name: "",
        contactNumber: null,
        siteNumber: "",
        isBought: false,
        usersDetail: [],
        showErrorMessage: false,
        errorMessage: "Please enter a value!"
    }
    componentDidMount() {
        this.getAllSitesData();
    }
    getAllSitesData = () => {
        axios.get("api/site").then((response) => {
            if(response.data && response.data.length > 0) {
                this.setState({data: response.data});
            } else {
                this.setState({data: [...data]});
            }
        })
    }
    handleClick = (cell, event) => {
        if (cell.value === 100) {
            return;
        }
        const siteNumber = cell.id;
        const userInfo = this.state.usersDetail.filter((userDetail) => userDetail.siteNumber === siteNumber)
        const isBought = userInfo && userInfo.length > 0 ? true : false;
        if (isBought) {
            const { name, siteNumber, contactNumber } = userInfo[0];
            this.setState({ modalIsOpen: true, selectedCell: cell, isBought, siteNumber, name, contactNumber })
        } else {
            this.setState({ modalIsOpen: true, selectedCell: cell, isBought, siteNumber });
        }
    }
    handleCloseModal = () => {
        this.setState({ modalIsOpen: false, selectedCell: null })
    }
    buyPlot = (e) => {
        e.preventDefault();
        const { selectedCell, data, name, siteNumber, contactNumber, usersDetail } = this.state;
        if (name && contactNumber) {
            if (selectedCell) {
                const updatedData = data.map((eachData, index) => {
                    if (eachData.site === selectedCell.yKey) {
                        return { ...eachData, [selectedCell.xKey]: 50 }
                    }
                    return { ...eachData };
                })
                const userInfo = { name, contactNumber, siteNumber };
                const filteredUsersDetails = usersDetail.filter((userDetail) => userDetail.siteNumber !== siteNumber);
                const updatedUsersDetail = [...filteredUsersDetails, userInfo];
                this.setState({ data: [...updatedData], usersDetail: updatedUsersDetail, selectedCell: null, modalIsOpen: false, name: "", contactNumber: null, siteNumber: "" });
            }
        } else {
            this.setState({ showErrorMessage: true })
            setTimeout(() => {
                this.setState({ showErrorMessage: false })
            }, 1000);
        }
    }
    editRegistration = (e) => {
        e.preventDefault();
        this.setState({ isBought: false });
    }
    render() {
        const customStyles = {
            content: {
                top: '50%',
                left: '50%',
                right: 'auto',
                bottom: 'auto',
                marginRight: '-50%',
                transform: 'translate(-50%, -50%)'
            }
        };
        const { data, hoverTarget, modalIsOpen, name, contactNumber, siteNumber, usersDetail, isBought, showErrorMessage, errorMessage } = this.state;
        return (<Fragment>
            <Modal
                ariaHideApp={false}
                isOpen={modalIsOpen}
                style={customStyles}
                onRequestClose={this.handleCloseModal}
            >
                <h2>Register Plot</h2>
                {showErrorMessage && <p style={{ color: "red", marginRight: "10px" }}>{errorMessage}</p>}
                <form>
                    <div className="Form-div">
                        <label>Name</label>
                        <input type="text" value={name} onChange={(e) => this.setState({ name: e.target.value })} disabled={isBought} />
                    </div>
                    <div className="Form-div">
                        <label>Contact Number</label>
                        <input type="tel" value={contactNumber} onChange={(e) => this.setState({ contactNumber: e.target.value })} disabled={isBought} />
                    </div>
                    <div className="Form-div">
                        <label>Site Number</label>
                        <input type="text" value={siteNumber} disabled />
                    </div>
                    {isBought ? <button onClick={this.editRegistration}>Edit</button> : <button onClick={this.buyPlot}>Buy</button>}
                    <button onClick={this.handleCloseModal}>Cancel</button>
                </form>
            </Modal>
            <div style={{ width: "800px", height: "800px" }}>
                <ResponsiveHeatMap
                    data={data}
                    keys={[
                        'Plot 1',
                        'Plot 2',
                        'Plot 3',
                        'Plot 4',
                        'Plot 5',
                        'Plot 6'
                    ]}
                    indexBy="site"
                    margin={{ top: 100, right: 60, bottom: 60, left: 60 }}
                    forceSquare={false}
                    axisTop={{ orient: 'top', tickSize: 5, tickPadding: 5, tickRotation: -90, legend: '', legendOffset: 36 }}
                    axisRight={null}
                    axisBottom={null}
                    axisLeft={{
                        orient: 'left',
                        tickSize: 5,
                        tickPadding: 5,
                        tickRotation: 0,
                        legend: '',
                        legendPosition: 'middle',
                        legendOffset: -40
                    }}
                    onClick={(cell, event) => this.handleClick(cell, event)}
                    tooltip={({ xKey, yKey, value, color }) => {
                        if (color === "#696969") {
                            // this.setState({hoverTarget: "row"});
                            return (
                                <strong>
                                    {yKey}
                                </strong>
                            )
                        } else {
                            // this.setState({hoverTarget: "cell"})
                            const siteNumber = xKey + "." + yKey;
                            const currentUser = usersDetail.filter(userDetail => userDetail.siteNumber === siteNumber);
                            return (
                                <strong>
                                    <p>{xKey}.{yKey}</p>
                                    <p>Plot size: 30*40 sqft</p>
                                    {(currentUser && currentUser.length > 0) ? <div>
                                        <p style={{ color: "red" }}>Plot already sold!</p>
                                        <p>Owner: {currentUser[0].name}</p>
                                        <p>Contact Details: {currentUser[0].contactNumber}</p>
                                    </div> : <div><p style={{ color: "green" }}>Available for sale!</p></div>}
                                </strong>
                            )
                        }
                    }}
                    cellOpacity={1}
                    enableLabels={false}
                    colors={["#7CFC00", "#b37819", "#696969"]}
                    cellBorderColor={{ from: 'color', modifiers: [['darker', 0.4]] }}
                    cellBorderWidth={"1px"}
                    labelTextColor={{ from: 'color', modifiers: [['darker', 1.8]] }}
                    defs={[
                        {
                            id: 'lines',
                            type: 'patternLines',
                            background: 'inherit',
                            color: 'rgba(0, 0, 0, 0.1)',
                            rotation: -45,
                            lineWidth: 4,
                            spacing: 7
                        }
                    ]}
                    fill={[{ id: 'lines' }]}
                    animate={true}
                    motionConfig="wobbly"
                    motionStiffness={80}
                    motionDamping={9}
                    hoverTarget={hoverTarget}
                    cellHoverOthersOpacity={0.25}
                />
            </div>
        </Fragment>
        )
    }
}