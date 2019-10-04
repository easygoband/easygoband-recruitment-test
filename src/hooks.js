import { useState, useEffect } from 'react';

function useFetch(url, auth) {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [status, setStatus] = useState([]);

  async function fetchUrl() {
    const response = await fetch(url, {
      method: 'get',
      headers: new Headers({
        Authorization: auth
      })
    });
    const json = await response.json();
    setData(json);
    setStatus(response.status);
    setLoading(false);
  }

  useEffect(() => {
    fetchUrl();
  }, []);

  return [data, loading, status];
}

export default useFetch;
