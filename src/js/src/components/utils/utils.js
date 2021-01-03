
const getData = url => fetch(`/${url}`,{
    method: 'GET', 
    mode: 'cors', 
    cache: 'no-cache', 
    headers: {
      'Content-Type': 'application/json'
    }}).then(res=>res.json());

const postData = (url, data) => {
  return fetch(`/${url}`,{
    method: 'POST', 
    mode: 'cors',
    cache: 'no-cache',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  }).then(res=>res.json());
}

export {
  getData,
  postData
}
