import { TypeAttachement } from "../enum/typeAttachement";
import { CloudinaryInformation } from "./cloudinaryInformation";

export class Attachment {
    id: number;
    typeAttachement: TypeAttachement;
    cloudinaryInformationList: CloudinaryInformation[];
    activeAttachement: number;
    positionAttachement: number;
}