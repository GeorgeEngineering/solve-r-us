import React, {useState} from 'react';
import {Row, Col, Typography, Input, Form, Button,
Radio, Switch, Slider, Select, message} from 'antd';
import axios from 'axios';
import {useNavigate} from 'react-router';
const {Title} = Typography;
const layout = {
  labelCol: { span: 8 },
  wrapperCol: { span: 16 },
};

const AddCustomer = () => {
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate ();

  const handleSubmit = (values) => {
    setLoading(true);
    axios.post(`http://localhost:8080/customers`,
      values
    )
    .then(res => {
      setLoading(false);
      message.success('Customer Added Successfully!');
      navigate('/customers');
    })
    .catch(error => {
      setLoading(false);
      message.error(error);
    })
  }

  return (
    <div>
        <Row gutter={[40, 0]}>
          <Col span={23}>
            <Title style={{textAlign: 'center'}} level={2}>
              Customer Form
            </Title>
            </Col>
        </Row>
        <Row gutter={[40, 0]}>
        <Col span={18}>
          <Form {...layout} onFinish={handleSubmit}>
            <Form.Item name="firstName" label="First Name"
            rules={[
              {
                required: true,
                message: 'Please input your first name',
              }
            ]}
            >
              <Input placeholder="Please enter your first name" />
            </Form.Item>
            <Form.Item name="lastName" label="Last Name"
                       rules={[
                         {
                           required: true,
                           message: 'Please input your last name',
                         }
                       ]}
            >
              <Input placeholder="Please enter your last name" />
            </Form.Item>
            <Form.Item name="email" label="Email"
            rules={[
              {
                required: true,
                message: 'Please input your correct email',
                type: 'email'
              }
            ]}
            >
              <Input placeholder="Please enter your email" />
            </Form.Item>
            <Form.Item name="state" label="State"
            rules={[
              {
                required: true,
                message: 'Please select your state',
              }
            ]}
            >
              <Radio.Group>
                <Radio value="MI">Michigan</Radio>
                <Radio value="FL">Florida</Radio>
                <Radio value="VA">Virginia</Radio>
              </Radio.Group>
            </Form.Item>
            <Form.Item name="city" label="City"
            rules={[
              {
                required: true,
                message: 'Please select your city',
                type: 'array'
              }
            ]}
            >
              <Select mode="multiple" placeholder="Please select you city">
                <Select.Option value="Pensacola">Pensacola</Select.Option>
                <Select.Option value="GrandRapids">Grand Rapids</Select.Option>
                <Select.Option value="Reston">Reston</Select.Option>
              </Select>
            </Form.Item>
            <Form.Item name="review" label="Review"
            >
              <Slider />
            </Form.Item>
            <Form.Item name="notificaiton" label="Notificaiton" valuePropName="checked"
            >
              <Switch />
            </Form.Item>
            <div style={{textAlign: "right"}}>
            <Button type="primary" loading={loading} htmlType="submit">
              Save
            </Button>{' '}
            <Button type="danger" htmlType="button" onClick={() => navigate('/customers')}>
              Back
            </Button>
              </div>
          </Form>
          </Col>
        </Row>
    </div>
  );
}

export default AddCustomer;