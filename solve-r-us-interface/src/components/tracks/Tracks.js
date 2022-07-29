import {useEffect, useState} from "react";
import axios from "axios";
import {Col, Row, Table, Typography} from "antd";
const {Title} = Typography;

const Tracks = () => {
    const [tracks, setTracks] = useState([]);

    useEffect(() => {
        axios.get(`http://localhost:5000/tracks`).then(result => {
            setTracks(result.data);
        });
    }, []);

    const columns = [
        {
            title: 'Name',
            dataIndex: 'name',
            key: 'name'
        },
        {
            title: 'Composer',
            dataIndex: 'composer',
            key: 'composer'
        },
        {
            title: 'Milliseconds',
            dataIndex: 'milliseconds',
            key: 'milliseconds'
        },
        {
            title: 'Unit Price',
            dataIndex: 'unitPrice',
            key: 'unitPrice'
        },
    ];

    const data = [{
    }];

    tracks.map((track) => {
        data.push({
            id: track.id,
            name: track.name,
            composer: track.composer,
            milliseconds: track.milliseconds,
            unitPrice: track.unitPrice
        })
        return data;
    });

    return (
        <div>
            <Row gutter={[40, 0]}>
                <Col span={18}>
                    <Title level={2}>
                        Track List
                    </Title>
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

export default Tracks;