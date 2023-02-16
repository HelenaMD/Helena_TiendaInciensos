export interface MensajeRespuesta<T> {
    code_respuesta:number;
    objeto_dominio:T;
    status_mensaje:string;
    
}