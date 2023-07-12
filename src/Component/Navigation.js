import React, { useState } from 'react';
import { NavLink as ReactLink } from 'react-router-dom';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
} from 'reactstrap';

function Navigation() {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  return (
    <div>
    <Navbar
    color='dark'
    dark
    expand="md"
    fixed=''>
    <NavbarBrand tag={ReactLink} to="/">SmartDeals</NavbarBrand>
    <NavbarToggler onClick={toggle} />
    <Collapse isOpen={isOpen} navbar>
      <Nav className="me-auto" navbar>
        <NavItem>
          <NavLink href="">
            Deals
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink tag={ReactLink} to="/support">Support</NavLink>
        </NavItem>
        <NavItem>
          <NavLink tag={ReactLink} to="/about">About</NavLink>
        </NavItem>
      </Nav>
    </Collapse>
  </Navbar>
</div>
);
}

export default Navigation;