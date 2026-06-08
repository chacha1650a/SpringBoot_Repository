import { Route, Routes } from "react-router";
import SignUp from "./pages/SignUp/SignUp";
import SignIn from "./pages/SignIn/SignIn";
import Todo from "./pages/Todo/Todo";
import ProtectedRoutes, { PublicOnlyRoute } from "./components/ProtectedRoutes";
import GlobalLayout from "./components/GlobalLayout/GlobalLayout";

function App() {

    return (
        <GlobalLayout>
            <Routes>
                <Route path="/" element={<></>} />

                <Route element={<PublicOnlyRoute />}>
                  <Route path="/auth/signup" element={<SignUp />} />
                  <Route path="/auth/signin" element={<SignIn />} />
                </Route>

                <Route element={<ProtectedRoutes />}>
                  <Route path="/dash" element={<></>} />
                  <Route path="/todos" element={<Todo />} />
                </Route>
            </Routes>
        </GlobalLayout>
    )
}

export default App;