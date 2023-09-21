import React from 'react'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link } from 'react-router-dom';

function NavBar() {
  return (
    <div>
    <Navbar bg="white" expand="lg">
    <Container>
      <Navbar.Brand>Academic Details</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="me-auto">
          <NavDropdown title="MENU" id="basic-nav-dropdown">
                    <NavDropdown.Item>Home</NavDropdown.Item>
                    <NavDropdown.Item><Link to="/" style={{textDecoration:"none",color:"inherit"}}>Sign up as Admin</Link></NavDropdown.Item>
                    <NavDropdown.Item><Link to="/stafflogin" style={{textDecoration:"none",color:"inherit"}}>Sign up as Staff</Link></NavDropdown.Item>
                    <NavDropdown.Item><Link to="/studentlogin" style={{textDecoration:"none", color:"inherit"}}>Sign up as Student</Link></NavDropdown.Item>
          </NavDropdown>
        </Nav>
      </Navbar.Collapse>
    </Container>
  </Navbar>
  </div>
  )
}

export default NavBar





