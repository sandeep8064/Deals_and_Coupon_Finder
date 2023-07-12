import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import axios from 'axios';
import '../Styles/Log.css'

function Log() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  async function login(event) {
    event.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/profile/login', {
        username: username,
        password: password,
      });

      if (response.status === 200 && response.data === 'Login successful') {
      
        navigate('/home');
      } else {
      
        alert('Login failed');
      }
    } catch (error) {
      console.error(error);
      alert('Invalid Credentials');
    }
  }

  return (
    <div>
      <div className="container">
        <div className="row">
          <h2>Login</h2>
          <hr />
        </div>
        <div className="row">
          <div className="col-sm-6">
            <form>
              <div className="form-group">
                <label>Username</label>
                <input
                  type="text"
                  className="form-control"
                  id="username"
                  placeholder="Enter Username"
                  value={username}
                  onChange={(event) => {
                    setUsername(event.target.value);
                  }}
                />
              </div>
              <br />
              <div className="form-group">
                <label>Password</label>
                <input
                  type="password"
                  className="form-control"
                  id="password"
                  placeholder="Enter Password"
                  value={password}
                  onChange={(event) => {
                    setPassword(event.target.value);
                  }}
                />
                <br />
              </div>
              <button type="submit" className="btn btn-primary" onClick={login}>
                Login
              </button>
            </form>
          </div>
        </div>
      </div>
      <div style={{ padding: '85px' }}>
        <p>Don't have an account?</p>
        
        <Link to="/signup">
          <button type="submit" className="btn btn-primary">
            Signup
          </button>
        </Link>
        </div>
        <div className="image-container">
        <img src="https://img.freepik.com/free-vector/social-media-marketing-mobile-phone-concept_23-2148431745.jpg?w=740&t=st=1688847660~exp=1688848260~hmac=384599f552f12cc36b02d1281ff826141569da182603de5669519d16ea491e53" alt="Background" className="background-image" />
      </div>
    </div>
  );
}

export default Log;
