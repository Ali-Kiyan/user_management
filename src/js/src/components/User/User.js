import React, { useState, useEffect } from "react";
import { getData } from "../utils/utils";
import { Table, Avatar, Spin } from "antd";
import { LoadingOutlined } from '@ant-design/icons';

const getAntIcon = () => <LoadingOutlined type="loading" style={{ fontSize: 24 }}></LoadingOutlined>;

const User = (props) => {
  const [users, setUsers] = useState();
  const [isLoading, setLoading] = useState(false);
  const cols = [
    {
      title: "",
      key: "avatar",
      render: (text, user) => (
        <Avatar size="large">
          {`${user.firstName.charAt(0).toUpperCase()}${user.lastName
            .charAt(0)
            .toUpperCase()}`}
        </Avatar>
      ),
    },
    {
      title: "User Id",
      dataIndex: "userId",
      key: "userId",
    },
    {
      title: "First Name",
      dataIndex: "firstName",
      key: "firstName",
    },
    {
      title: "Last Name",
      dataIndex: "lastName",
      key: "lastName",
    },
    {
      title: "Email",
      dataIndex: "email",
      key: "email",
    },
  ];
  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      const users = await getData("users");
      setUsers(users);
      setLoading(false);
    };
    fetchData();
  }, []);
  const renderTable = () => {
    if (isLoading) {
      return (
        <Spin
          indicator={getAntIcon()}
        ></Spin>
      );
    } else {
      return (
        <Table
          dataSource={users}
          columns={cols}
          rowKey="userId"
          style={{
            width: "80%",
            margin: "0 auto",
          }}
          pagination={false}
        ></Table>
      );
    }
  };
  return renderTable();
};

export default User;
