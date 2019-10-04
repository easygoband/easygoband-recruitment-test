import React from 'react';
import useFetch from './hooks';
import Accesses from './scenes/Accesses';
import styled, { createGlobalStyle } from 'styled-components';
import CONSTANTS from './constants';

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
    CONSTANTS.API_URL,
    CONSTANTS.API_AUTH
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
