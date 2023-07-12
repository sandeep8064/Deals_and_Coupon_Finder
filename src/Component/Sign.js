import { useState } from "react";
import axios from "axios";



const Sign = () => {

    const [username, setusername] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    async function save(event) {
        event.preventDefault();
        try {
          await axios.post("http://localhost:8080/profile/reg", {
          username: username,
          password: password,
          email: email
          });
          alert("Registered Successfully");
        } catch (err) {
          alert(err);
        }
      }
  
    return (
    <div>
    <div class="container mt-4" >
    <div class="card">
            <h3>Signup</h3>
            <br />
    
    <form>
        <div class="form-group">
          <label>Name</label>
          <input type="text"  class="form-control" id="employeename" placeholder="Enter Name"
          
          value={username}
          onChange={(event) => {
            setusername(event.target.value);
          }}
          />
        </div>
        <br />
        <div class="form-group">
          <label>Email</label>
          <input type="email"  class="form-control" id="email" placeholder="Enter Email"
          
          value={email}
          onChange={(event) => {
            setEmail(event.target.value);
          }}
          
          />
 
        </div>
        <br />
        <div class="form-group">
            <label>Password</label>
            <input type="password"  class="form-control" id="password" placeholder="Enter password"
            
            value={password}
            onChange={(event) => {
              setPassword(event.target.value);
            }}
            
            />
          </div>
          <br />
        <button type="submit" class="btn btn-primary mt-4" onClick={save} >Save</button>
       
      </form>
    </div>
    </div>
     </div>
    );
}

export default Sign