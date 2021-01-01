import React, {useState, useEffect} from 'react';
import { getData } from '../utils/utils'
const User = (props) => {
    const [users, setUsers] = useState();

    useEffect(async ()=>{
            const users = await getData("users");
            setUsers(users);
    }, [])
    const showUsers = ()=>{
        return users.map(item=>(
                <span style={{

                    display: 'flex',
                    flexDirection: 'column'
                }}>
                    
                <span>
                First Name: {item.firstName}
              </span>
              <span>
                Last Name: {item.lastName}
              
                </span>
                <span>
                Email: {item.email}
                </span>
                </span>
        ))
    }
    return (
        <div style={{
            display: 'flex',
            flexDirection: 'column'
        }}>
        {
        users && showUsers()
        }
    </div>
    )
}

export default User;