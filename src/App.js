import React from 'react';
import useFetch from './hooks';
import Accesses from './scenes/Accesses';
import styled, { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
  body {
    margin: 0;
    padding: 0;
    font-family: 'Nunito Sans', sans-serif;
    background-color: #FFF;
  }
  h1 {
    font-size: 2rem;
    font-weight: 700;
  }
  a {
    color: #000;
    text-decoration: none;
  }
`;

const Container = styled.section`
  max-width: 70rem;
  margin: 2.5rem auto;
  padding: 0 0.5rem;
`;

function App() {
  const [data, loading, status] = useFetch(
    'https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1',
    'Basic cJmAc71jah17sgqi1jqaksvaksda='
  );

  return (
    <>
      <GlobalStyle />
      <Container>
        {loading ? (
          <p>Loading...</p>
        ) : status === 200 ? (
          <Accesses data={data} />
        ) : (
          <p>Ooops.. something went wrong, please try again later</p>
        )}
      </Container>
    </>
  );
}

export default App;
