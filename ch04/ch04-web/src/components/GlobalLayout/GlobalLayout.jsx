import { Global, css } from '@emotion/react';
import * as s from './styles';

const globalStyles = css`
  body, html {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
    font-family: 'Inter', 'Roboto', 'Helvetica Neue', sans-serif;
    color: #fff;
    background-color: #090a0f;
  }

  * {
    box-sizing: border-box;
  }

  @keyframes animStar {
    from { transform: translateY(0px) }
    to { transform: translateY(-3000px) }
  }
`;

function GlobalLayout({ children }) {
    return (
        <div css={s.globalLayout}>
            <Global styles={globalStyles} />
            <div css={s.globalBackground}>
                <div css={s.stars}></div>
                <div css={s.stars2}></div>
                <div css={s.stars3}></div>
            </div>
            {children}
        </div>
    );
}

export default GlobalLayout;
