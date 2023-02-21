import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ConexionService } from './conexion.service';

describe('ConexionService', () => {
  let service: ConexionService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(ConexionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('leerApi existe', () => {
    expect(service.leerApi).toBeTruthy();
  });

  it('leerApi en /categoria devuelve todas las categorias', () => {
    let jsonResponse = '{"code_respuesta": 202,"status_mensaje": "Ok.", "objeto_dominio": [{"id_categoria": 4953,"cat_nombre": "Dos aaa","cat_descripcion": "AAAAAAAA"},{"id_categoria": 5052,"cat_nombre": "feaff","cat_descripcion": "dafdafd"},{"id_categoria": 5002,"cat_nombre": "Hola que tal","cat_descripcion": "decripcion"},{"id_categoria": 2967,"cat_nombre": "Aqui estoy volviendo a probar","cat_descripcion": "Holi"},{"id_categoria": 2962,"cat_nombre": "Inciensos baratos","cat_descripcion": "Y muy aromaticos"}]}';
    let listadoMens = '';
    service.leerApi('categoria').subscribe((resp:any) => {
      listadoMens = resp;
    })
    expect(listadoMens).toBe(jsonResponse);
  })

  it('postApi existe', () => {
    expect(service.postApi).toBeTruthy();
  });

  it('putApi existe', () => {
    expect(service.putApi).toBeTruthy();
  });

  it('deleteApi existe', () => {
    expect(service.deleteApi).toBeTruthy();
  });
});
