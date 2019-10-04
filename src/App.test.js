const useFetch = require('./fakeFetch');

describe('fetch api', () => {
  it('fake api call with 200 status code', () => {
    const [data, status] = useFetch(200);
    expect(status).toEqual(200);
    expect(Object.keys(data).length).toBeGreaterThan(0);
    expect(data[0].sessions.length).toBeGreaterThan(0);
    expect(data[0].access_group_name).toEqual('Membership');
  });

  it('fake api call with 404 status code', () => {
    const [data, status] = useFetch(404);
    expect(status).toEqual(404);
    expect(data).toEqual(null);
  });
});
