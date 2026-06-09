import { css } from "@emotion/react";

function generateStars(n) {
  let value = `${Math.floor(Math.random() * 3000)}px ${Math.floor(Math.random() * 3000)}px 1px #FFF`;
  for(let i=2; i<=n; i++) {
    value += `, ${Math.floor(Math.random() * 3000)}px ${Math.floor(Math.random() * 3000)}px 1px rgba(255, 255, 255, ${0.5 + Math.random() * 0.5})`;
  }
  return value;
}

const shadowsSmall = generateStars(500);
const shadowsMedium = generateStars(200);
const shadowsLarge = generateStars(100);

export const globalBackground = css`
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background: radial-gradient(ellipse at bottom, #0d1321 0%, #000000 100%);
  overflow: hidden;
  z-index: -1;
`;

export const stars = css`
  width: 2px;
  height: 2px;
  border-radius: 50%;
  background: transparent;
  box-shadow: ${shadowsSmall};
  animation: animStar 50s linear infinite;

  &:after {
    content: " ";
    position: absolute;
    top: 3000px;
    width: 2px;
    height: 2px;
    border-radius: 50%;
    background: transparent;
    box-shadow: ${shadowsSmall};
  }
`;

export const stars2 = css`
  width: 3px;
  height: 3px;
  border-radius: 50%;
  background: transparent;
  box-shadow: ${shadowsMedium};
  animation: animStar 100s linear infinite;

  &:after {
    content: " ";
    position: absolute;
    top: 3000px;
    width: 3px;
    height: 3px;
    border-radius: 50%;
    background: transparent;
    box-shadow: ${shadowsMedium};
  }
`;

export const stars3 = css`
  width: 4px;
  height: 4px;
  border-radius: 50%;
  background: transparent;
  box-shadow: ${shadowsLarge};
  animation: animStar 150s linear infinite;

  &:after {
    content: " ";
    position: absolute;
    top: 3000px;
    width: 4px;
    height: 4px;
    border-radius: 50%;
    background: transparent;
    box-shadow: ${shadowsLarge};
  }
`;

export const globalLayout = css`
  position: relative;
  min-height: 100vh;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;
