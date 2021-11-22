import axios from 'axios'

const URI = 'https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers'
const ID = 1
const AUTHORIZATION = process.env.VUE_APP_AUTHORIZATION || 'default'

export async function getEvents () {
  const events = await axios.get(`${URI}/${ID}`, {
    headers: {
      Authorization: AUTHORIZATION
    }
  })
  return events.data
}
