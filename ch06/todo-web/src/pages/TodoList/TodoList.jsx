import { useNavigate, useParams } from "react-router";
import { useTodoList } from "../../hooks/queries/useTodoList";
import * as s from "./styles";
import { useCategories, useCategoryNotCompletedCount } from "../../hooks/queries/useCategory";
import Header from "../../components/Header/Header";
import TextButton from "../../components/buttons/TextButton/TextButton";
import { PRIORITIES } from "../../constants/globalConstants";
import { useTodoCompleteMutaion } from "../../hooks/mutations/useTodo";
import { useMe } from "../../hooks/queries/useUser";
import { title } from "../Home/styles";

function TodoList() {
    const navigate = useNavigate();
    const { categoryName } = useParams();
    const meQuery = useMe();
    const categoriesQuery = useCategories();
    const categoryId = categoriesQuery.isLoading
        || categoriesQuery.data.body.find(c => c.categoryName === categoryName).caetgoryId;

    const category = categoriesQuery.isLoading || categoriesQuery.data.body.find(c => c.categoryName === categoryName);

    const todoListQuery = useTodoList();
    const todoList = (todoListQuery.isLoading && [])
        || todoListQuery.data.body.filter(todo => todo.categoryId === category.categoryId);

    const completeTodoList = todoList.filter(todo => todo.completed);
    const notCompleteTodoList = todoList.filter(todo => !todo.completed);
    const categoryCountsQuery = useCategoryNotCompletedCount();

    const notCompletedCount = categoryCountsQuery.data?.body.find(c => c.id === category.categoryId).notCompletedCount;
    const completedCount = categoryCountsQuery.data?.body.find(c => c.id === category.categoryId).totalCount - notCompletedCount;

    const updateCompletionMutation = useTodoCompleteMutaion();

    const handleCompleteOnClick = (currentChecked, todoId) => {
        updateCompletionMutation.mutateAsync({
            todoId: todoId,
            userId: meQuery.data.body.userId,
            completed: !currentChecked,
        });
    }

    const handleToHomeOnClick = () => {
        navigate("/");
    }

    return (
        <div css={s.layout}>
            <Header>
                <TextButton onClick={handleToHomeOnClick}>&lt; 홈</TextButton>
                <h4>{category.categoryName}</h4>
                <TextButton>...</TextButton>
            </Header>
            <main css={s.main}>
                <div css={s.header(category.categoryColor)}>
                    <div>{category.categoryIcon}</div>
                    <div>
                        <div>{category.categoryName}</div>
                        <div>{notCompletedCount}개의 할일</div>
                    </div>
                </div>
                <div>
                    <ul css={s.notCompletedUl}>
                        {
                            notCompleteTodoList.map(todo => (
                                <li>
                                    <div>
                                        <input type="checkbox" checked={todo.completed} onClick={() => handleCompleteOnClick(todo.completd, todo.todoId)}/>
                                    </div>
                                    <div>
                                        <div>
                                            <div>{todo.title}</div>
                                            <div>
                                                {PRIORITIES.find(p => p.id === todo.priority).icon}
                                            </div>
                                        </div>
                                        <div>{todo.dueDate} {todo.dueTime}</div>
                                        <div>{todo.memo}</div>
                                    </div>
                                </li>
                            ))
                        }
                    </ul>
                </div>
                <div css={s.completedBox}>
                    <div css={s.completedText}>
                        완료됨 {completedCount}개
                    </div>
                    <ul css={s.completedUl}>
                        {
                            completeTodoList.map(todo => (
                                <li>
                                    <div>
                                        <input type="checkbox" checked={todo.completd} onClick={}/>
                                    </div>
                                    <div>{todo.title}</div>
                                </li>
                            ))
                        }
                    </ul>
                    <div>
                        <TextButton onClick={() => navigate(`/register`)}>새로운 할 일 추가</TextButton>
                    </div>
                </div>
            </main>
        </div>
    )
}

export default TodoList;