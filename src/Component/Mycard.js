import React from 'react'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

const Mycard = () => {
  return (
    <Card style={{ width: '18rem' }}>
    <Card.Img variant="top" src="holder.js/100px180" />
    <Card.Body>
      <Card.Title></Card.Title>
      <Card.Text>
       
      </Card.Text>
      <Button variant="primary">Button</Button>
    </Card.Body>
  </Card>
  )
}

export default Mycard