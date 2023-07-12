import React from 'react';
import PropTypes from 'prop-types';

const Header = ({ title, color }) => {
  const headerStyle = {
    backgroundColor: color,
    padding: '20px',
    color: 'white',
    fontFamily: 'Arial',
    borderRadius: '8px',
    boxShadow: '0px 2px 4px rgba(0, 0, 0, 0.2)',
    width: '100%',
    boxSizing: 'border-box',
  };

  const headerWrapperStyle = {
    paddingBottom: '30px', // Adjust the value as per your needs
  };

  const titleStyle = {
    fontSize: '30px',
    marginBottom: '10px',
    textAlign: 'center',
  };

  return (
    <div style={headerStyle}>
      <h1 style={titleStyle}>{title}</h1>
    </div>
  );
};

Header.propTypes = {
  title: PropTypes.string.isRequired,
  color: PropTypes.string,
};

Header.defaultProps = {
  color: 'blue',
};

export default Header;
