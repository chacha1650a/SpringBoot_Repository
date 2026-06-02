import { Route, Routes } from "react-router";
import Roles from "./pages/Roles/Roles";
import UserCreate from "./pages/UserCreate";
import UserList from "./pages/UserList";
import UserDetails from "./pages/UserDetails";


function App() {

    return (
        <>
          <Routes>
              <Route path="/users/create" element={<UserCreate/>} />
              <Route path="/users" element={<UserList/>} />
              <Route path="/users/:userId" element={<UserDetails />} />
              <Route path="/roles/create" element={<></>} />
              <Route path="/roles" element={<Roles />} />
          </Routes>
        </>
    )
}

export default App;