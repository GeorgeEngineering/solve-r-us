import React, {useEffect, useState} from 'react';
import {Table, Row, Col, Button, Typography} from 'antd';
import {useNavigate} from 'react-router';
import axios from 'axios';
const {Title} = Typography;

const Customers = () => {
    const navigate = useNavigate ();
    const [customers, setCustomers] = useState([]);

    useEffect(() => {
        axios.get(`http://localhost:8080/customers`).then(result => {
            setCustomers(result.data);
        });
    }, []);

    const columns = [
        {
            title: 'First Name',
            dataIndex: 'firstName',
            key: 'firstName'
        },
        {
            title: 'Last Name',
            dataIndex: 'lastName',
            key: 'lastName'
        },
        {
            title: 'City',
            dataIndex: 'city',
            key: 'city'
        },
        {
            title: 'State',
            dataIndex: 'state',
            key: 'state'
        },
    ];

    const data = [{
    }];

    customers.map((customer) => {
        data.push({
            id: customer.id,
            firstName: customer.firstName,
            lastName: customer.lastName,
            city: customer.city,
            state: customer.state
        })
        return data;
    });

    const handleClick = () => {
        navigate('/add-customer');
    }

    return (
        <div>
            <Row gutter={[40, 0]}>
                <Col span={18}>
                    <Title level={2}>
                        Customer List
                    </Title>
                </Col>
                <Col span={6}>
                    <Button onClick={handleClick} block>Add Customer</Button>
                </Col>
            </Row>
            <Row gutter={[40, 0]}>
                <Col span={24}>
                    <Table columns={columns} dataSource={data} rowKey="id" />
                </Col>
            </Row>
        </div>
    );
}

export default Customers;