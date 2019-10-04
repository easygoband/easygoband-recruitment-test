import React, { useState } from 'react';
import styled from 'styled-components';

const Table = styled.div`
  max-width: 100%;
  min-width: 45rem;
`;
const Element = styled.div`
  padding: 0.25rem;
`;
const columnWidth = `
  ${Element}:first-child {
    width: 15%;
  }
  ${Element}:nth-child(2) {
    width: 35%;
  }
  ${Element}:nth-child(3) {
    width: 25%;
  }
  ${Element}:last-child {
    width: 25%;
  }
`;
const Header = styled.div`
  display: flex;
  font-weight: 700;
  ${columnWidth}
  background: #c0d1ce;
  padding: 0.25rem 0.5rem;
`;
const Row = styled.div`
  display: flex;
  align-items: baseline;
  ${columnWidth}
  &:nth-child(odd) {
    background-color: rgba(192, 209, 206, 0.2);
  }
  &:hover {
    color: rgba(0, 0, 0, 0.4);
  }
  border: solid 0.1rem #d1e5e1;
  border-top: 0;
  padding: 0 0.5rem;
`;
const Search = styled.input`
  margin-bottom: 0.5rem;
  padding: 0.25rem;
  border: solid 0.1rem #d1e5e1;
`;

function Accesses(props) {
  const [searchTerm, setsearchTerm] = useState('');

  return (
    <Table>
      <Search
        type="text"
        placeholder="Filter by name"
        onChange={e => setsearchTerm(e.target.value)}
      />
      <Header>
        <Element>Product ID</Element>
        <Element>Name</Element>
        <Element>Group Name</Element>
        <Element>Sessions</Element>
      </Header>
      {props.data
        .filter(access => access.name.includes(searchTerm))
        .map((access, i) => {
          return (
            <Row key={i}>
              <Element>{access.basic_product_id}</Element>
              <Element>{access.name}</Element>
              <Element>{access.access_group_name}</Element>
              <Element>
                {access.sessions.map((session, i, arr) => {
                  return ` ${session.name}${arr.length - 1 !== i ? ', ' : ''}`;
                })}
              </Element>
            </Row>
          );
        })}
    </Table>
  );
}

export default Accesses;
