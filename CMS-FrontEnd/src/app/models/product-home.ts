import { Image } from "./image";

export interface Product {
    id: number,
    price: number,
    name: string,
    category: string,
    description: string,
    images:Image[],
}


