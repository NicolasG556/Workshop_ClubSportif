import * as internal from "stream";
import { Role } from "./role.model";

export class User{
    user_id!:number;
    enabled!:number;
    username!:string ;
    password!: string ;
    roles!:Role[];
    nom!:string;
    prenom!:string;
    civilite!:number;
    anneeNaissance!:string;
    ville!:string;
    codePostal!:string;
    pays!:string;
    adresse!:string;
    civiliteLettres!:string


    }