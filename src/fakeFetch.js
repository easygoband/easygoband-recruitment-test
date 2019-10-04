module.exports = function useFetch(statusCode) {
  let data = '';
  switch (statusCode) {
    case 200:
      data = [
        {
          access_group_name: 'Membership',
          access_group_id: 1,
          total_uses: 0,
          sessions: [
            {
              name: '01-VIP',
              id: 37
            }
          ],
          event_id: 1,
          structure_decode: false,
          name: 'MEMBERSHIP VIP',
          modified: '2019-10-01T17:42:27.000Z',
          id: 73,
          basic_product_id: 19
        },
        {
          access_group_name: 'Membership',
          access_group_id: 1,
          total_uses: 0,
          sessions: [
            {
              name: '02-SURFERS',
              id: 4
            }
          ],
          event_id: 1,
          structure_decode: false,
          name: 'MEMBERSHIP SURFERS',
          modified: '2019-10-01T13:42:27.000Z',
          id: 13,
          basic_product_id: 31
        }
      ];
      break;

    default:
      data = null;
      break;
  }
  return [data, statusCode];
};
