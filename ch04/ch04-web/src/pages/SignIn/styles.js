import { css } from "@emotion/react";

export const cardWrapper = css`
  position: relative;
  border-radius: 16px;
  padding: 2px;
  overflow: hidden;
  margin: 20px;
  transition: transform 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
  box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.37);

  &::before {
    content: '';
    position: absolute;
    top: -50%;
    left: -50%;
    width: 200%;
    height: 200%;
    background: conic-gradient(
      transparent, 
      #ff007f, #7f00ff, #00f0ff, #00ff7f, #ff007f,
      transparent 25%
    );
    animation: spinBorder 4s linear infinite;
    z-index: 1;
    opacity: 0;
    transition: opacity 0.3s ease;
  }

  &:hover {
    transform: translateY(-10px);
    
    &::before {
      opacity: 1;
    }
  }
`;

export const cardContent = css`
  position: relative;
  background: rgba(15, 20, 35, 0.85);
  backdrop-filter: blur(20px);
  -webkit-backdrop-filter: blur(20px);
  border-radius: 14px;
  padding: 50px 40px;
  z-index: 2;
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 400px;
  box-sizing: border-box;
  
  h1 {
    color: #fff;
    margin: 0 0 30px;
    font-weight: 300;
    font-size: 28px;
    letter-spacing: 2px;
  }
`;

export const linkText = css`
  margin-top: 20px;
  font-size: 14px;
  color: #ccc;
  width: 100%;
  text-align: center;
  
  a {
    color: #00f0ff;
    text-decoration: none;
    font-weight: 500;
    margin-left: 5px;
    transition: color 0.2s ease;
    
    &:hover {
      color: #fff;
      text-shadow: 0 0 8px rgba(0, 240, 255, 0.8);
    }
  }
`;

export const inputGroup = css`
  width: 100%;
  margin-bottom: 20px;

  input {
    width: 100%;
    background: rgba(255, 255, 255, 0.05);
    border: 1px solid rgba(255, 255, 255, 0.1);
    border-radius: 8px;
    padding: 14px 16px;
    color: #fff;
    font-size: 16px;
    outline: none;
    transition: all 0.3s ease;
    box-sizing: border-box;

    &::placeholder {
      color: rgba(255, 255, 255, 0.4);
    }

    &:focus {
      background: rgba(255, 255, 255, 0.1);
      border-color: #00f0ff;
      box-shadow: 0 0 10px rgba(0, 240, 255, 0.3);
    }
  }
`;

export const buttonGroup = css`
  width: 100%;
  margin-top: 10px;

  button {
    width: 100%;
    background: linear-gradient(135deg, rgba(0, 240, 255, 0.8) 0%, rgba(0, 100, 255, 0.8) 100%);
    border: none;
    border-radius: 8px;
    padding: 14px 0;
    color: #fff;
    font-size: 16px;
    font-weight: 500;
    letter-spacing: 1px;
    cursor: pointer;
    transition: all 0.3s ease;
    box-shadow: 0 4px 15px rgba(0, 150, 255, 0.3);

    &:hover {
      transform: translateY(-2px);
      box-shadow: 0 6px 20px rgba(0, 150, 255, 0.5);
      background: linear-gradient(135deg, rgba(0, 255, 255, 0.9) 0%, rgba(0, 120, 255, 0.9) 100%);
    }

    &:active {
      transform: translateY(1px);
      box-shadow: 0 2px 10px rgba(0, 150, 255, 0.3);
    }
  }
`;
