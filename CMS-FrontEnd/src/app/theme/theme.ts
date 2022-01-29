export interface Theme {
    name: string;
    properties: any;
}

export const light: Theme = {
    name: "light",
    properties: {
        "--primary-default": "#1B568E",
        "--primary-dark": "#14409a30",
        "--primary-light": "white",

        "--primary-hover-default": "#a1d0ff",
        "--primary-hover-dark": "#14409a30",
        "--primary-hover-light": "white",

        "--primary-active-default": "#55A8FD",
        "--primary-active-dark": "#14409a30",
        "--primary-active-light": "white",

        "--error-default": "red",
        "--error-dark": "#800600",
        "--error-light": "#FFCECC",
    }
};

export const dark: Theme = {
    name: "dark",
    properties: {
        "--primary-default": "green",
        "--primary-dark": "#14409a30",
        "--primary-light": "black",

        "--primary-hover-default": "blue",
        "--primary-hover-dark": "#14409a30",
        "--primary-hover-light": "black",

        "--primary-active-default": "orange",
        "--primary-active-dark": "#14409a30",
        "--primary-active-light": "black",

        "--error-default": "red",
        "--error-dark": "#800600",
        "--error-light": "#FFCECC",
    }
};