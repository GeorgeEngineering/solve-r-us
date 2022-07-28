import React, {useState, useEffect} from 'react';
import {BrowserRouter as Router, Route, Routes, Navigate} from "react-router-dom";
import SideNavigation from "../components/common/SideNavigation";
import { Layout } from 'antd';
import {MenuUnfoldOutlined,MenuFoldOutlined} from '@ant-design/icons';
import Customers from "../components/customers/Customers";
import Tracks from "../components/tracks/Tracks";
import AddCustomer from "../components/customers/AddCustomer";

const { Header, Sider, Content} = Layout;

const ApplicationRoutes = () => {
    const [collapse, setCollapse] = useState(false);

    useEffect(() => {
        window.innerWidth <= 760 ? setCollapse(true) : setCollapse(false);
    }, []);

    const handleToggle = (event) => {
        event.preventDefault();
        collapse ? setCollapse(false) : setCollapse(true);
    }

    return (
        <Router>
            <Layout>
                <Sider trigger={null} collapsible collapsed={collapse}>
                    <SideNavigation collapsed={collapse}/>
                </Sider>
                <Layout>
                    <Header className="siteLayoutBackground" style={{padding: 0, background: "#001529"}}>
                        {React.createElement(collapse ? MenuUnfoldOutlined : MenuFoldOutlined, {
                            className: 'trigger',
                            onClick: handleToggle,
                            style: {color: "#fff"}
                        })}
                    </Header>
                    <Content style={{margin: '24px 16px', padding: 24, minHeight: "calc(100vh - 114px)", background: "#fff"}}>
                        <Routes>
                            <Route path="/customers" element={<Customers />} />
                            <Route path="/tracks" element={<Tracks />} />
                            <Route path="/add-customer" element={<AddCustomer />} />
                            <Route path="/" element={<Navigate to="/customers" replace={true} />} />
                        </Routes>
                    </Content>
                </Layout>
            </Layout>
        </Router>
    );
}

export default ApplicationRoutes;