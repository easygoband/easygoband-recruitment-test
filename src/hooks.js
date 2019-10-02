import { useState, useEffect } from 'react';

function useFetch(url, auth) {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);

  async function fetchUrl() {
    const response = await fetch(url, {
      method: 'get',
      headers: new Headers({
        Authorization: auth
      })
    });
    const json = await response.json();
    setData(json);
    setLoading(false);
  }

  useEffect(() => {
    fetchUrl();
  }, []);

  return [data, loading];
}

export default useFetch;
