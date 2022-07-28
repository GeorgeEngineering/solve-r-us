import React from 'react';
import {Menu,Typography} from 'antd';
import {UserOutlined, CustomerServiceOutlined} from '@ant-design/icons';
import {useNavigate} from "react-router";

const { Title } = Typography;

const SideNavigation = (props) => {
    const navigate = useNavigate ();
    const collapsed = props.collapsed;
    const handleCustomerClick = () => {
        navigate('/customers');
    }
    const handleTrackClick = () => {
        navigate('/tracks');
    }
    return (
        <div>
            <div className="res-circle">
                {!collapsed ?
                    <div className="circle-txt">Solve</div>
                    :
                    <div className="circle-txt">S</div>
                }
            </div>
            <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
                <Menu.Item key="1" onClick={handleCustomerClick}>
                    <UserOutlined />
                    <span> Customers</span>
                </Menu.Item>
                <Menu.Item key="2" onClick={handleTrackClick}>
                    <CustomerServiceOutlined />
                    <span> Tracks</span>
                </Menu.Item>
            </Menu>
        </div>
    );
}

export default SideNavigation;