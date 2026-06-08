import { css } from "@emotion/react";

export const container = css`
    width: 100%;
    max-width: 600px;
    margin: 40px auto;
    padding: 30px;
    background-color: #ffffff;
    border-radius: 12px;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.05);
    display: flex;
    flex-direction: column;
    gap: 20px;
`;

export const header = css`
    font-size: 28px;
    font-weight: 700;
    color: #1f2937;
    margin-bottom: 10px;
    text-align: center;
`;

export const inputGroup = css`
    display: flex;
    gap: 10px;

    input {
        flex: 1;
        padding: 12px 16px;
        border: 1px solid #e5e7eb;
        border-radius: 8px;
        font-size: 16px;
        outline: none;
        transition: border-color 0.2s;

        &:focus {
            border-color: #3b82f6;
        }
    }

    button {
        padding: 12px 24px;
        background-color: #3b82f6;
        color: white;
        border: none;
        border-radius: 8px;
        font-size: 16px;
        font-weight: 600;
        cursor: pointer;
        transition: background-color 0.2s;

        &:hover {
            background-color: #2563eb;
        }
    }
`;

export const todoList = css`
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    flex-direction: column;
    gap: 12px;
`;

export const todoItem = (done) => css`
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 16px;
    background-color: #f9fafb;
    border: 1px solid #e5e7eb;
    border-radius: 8px;
    transition: all 0.2s;

    &:hover {
        background-color: #f3f4f6;
    }

    .content-wrapper {
        display: flex;
        align-items: center;
        gap: 12px;
        flex: 1;

        input[type="checkbox"] {
            width: 20px;
            height: 20px;
            cursor: pointer;
        }

        span {
            font-size: 16px;
            color: ${done ? '#9ca3af' : '#1f2937'};
            text-decoration: ${done ? 'line-through' : 'none'};
            word-break: break-all;
        }
    }

    button {
        background: none;
        border: none;
        color: #ef4444;
        font-size: 14px;
        font-weight: 600;
        cursor: pointer;
        padding: 8px;
        border-radius: 6px;

        &:hover {
            background-color: #fee2e2;
        }
    }
`;
