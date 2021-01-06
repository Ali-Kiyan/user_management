import React, { useState, useEffect } from "react";
import { getData } from "../utils/utils";
import { Table, Avatar, Spin, Modal, Button } from "antd";
import { LoadingOutlined } from "@ant-design/icons";
import UserForm from "./UserForm";
import { errorNotification } from "../utils/notification";

const getAntIcon = () => (
  <LoadingOutlined type="loading" style={{ fontSize: 24 }}></LoadingOutlined>
);

const User = (props) => {
  const [users, setUsers] = useState();
  const [isLoading, setLoading] = useState(false);
  const [isAddUserModalVisible, setAddUserModal] = useState(false);

  const openAddUserModal = () => {
    setAddUserModal(true);
  };
  const closeAddUserModal = () => {
    setAddUserModal(false);
  };
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
      try {
        const users = await getData("users");
        setUsers(users);
        setLoading(false);
      } catch (error) {
        if(error.message.message){
          const title = error.message.message;
          const message = error.message.error;
          errorNotification(title, message)
        }else if(error.message){
          const title = "Error";
          const message = error.message;
          errorNotification(title, message)
        }
      }
    };
    fetchData();
  }, []);
  const renderTable = () => {
    if (isLoading) {
      return <Spin indicator={getAntIcon()}></Spin>;
    } else {
      return (
        <>
          <Button type="primary" onClick={() => openAddUserModal()}>
            Add new user
          </Button>
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
          <Modal
            title="Add new User"
            visible={isAddUserModalVisible}
            onOk={closeAddUserModal}
            onCancel={closeAddUserModal}
            width={"70%"}
          >
            <UserForm
              onSuccess={() => {
                closeAddUserModal();
              }}
            ></UserForm>
          </Modal>
        </>
      );
    }
  };
  return renderTable();
};

export default User;
