import { css } from "@emotion/react";
import { cardWrapper, cardContent, inputGroup, buttonGroup, linkText } from "../SignIn/styles";

// Re-export common styles
export { cardWrapper, cardContent, inputGroup, buttonGroup, linkText };

export const errorText = css`
  color: #ff4d4f;
  font-size: 12px;
  margin-top: -15px;
  margin-bottom: 15px;
  width: 100%;
  text-align: left;
  padding-left: 16px;
  min-height: 14px;
`;
