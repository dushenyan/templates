import type {Executor} from './';
import {DtoStyleController, EntityStyleController} from './services/';

export class Api {
    
    readonly dtoStyleController: DtoStyleController
    
    readonly entityStyleController: EntityStyleController
    
    constructor(executor: Executor) {
        this.dtoStyleController = new DtoStyleController(executor);
        this.entityStyleController = new EntityStyleController(executor);
    }
}