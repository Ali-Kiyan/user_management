
const getData = (url) => {
  return fetch(`/${url}`,{
    method: 'GET', 
    mode: 'cors', // no-cors, *cors, same-origin
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    headers: {
      'Content-Type': 'application/json'
    }}).then(data=>data.json());
}

export {
  getData
}
