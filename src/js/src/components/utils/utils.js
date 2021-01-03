const checkStatus = async(response) => {
  if (response.ok) {
    return response;
  } else {
    console.log(response)
    let error = new Error(response.statusText);
    error.response = response;
    const message = await response.json();
    error.message = message;
    return Promise.reject(error)
  }
};

const getData = (url) =>
  fetch(`/${url}`, {
    method: "GET",
    mode: "cors",
    cache: "no-cache",
    headers: {
      "Content-Type": "application/json",
    },
  }).then(checkStatus).then((res) => res.json());

const postData = (url, data) => {
  return fetch(`/${url}`, {
    method: "POST",
    mode: "cors",
    cache: "no-cache",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  }).then(checkStatus).then((res) => res.json());
};

export { getData, postData };
