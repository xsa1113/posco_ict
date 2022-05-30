import { createContext } from "react";
import { themes } from "./Themes";


export const ThemeContext = createContext({ themes: themes.dark, changeMode: () => {} });