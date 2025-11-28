import type {Executor} from '../';
import type {
    ComplexBookView, 
    RecursiveTreeNodeView, 
    SimpleBookView, 
    SimpleTreeNodeView
} from '../model/static/';

export class DtoStyleController {
    
    constructor(private executor: Executor) {}
    
    /**
     * 查询复杂的图书对象。
     * 
     * <p>如果指定了此参数，则仅查询名称与指定名称匹配的图书。</p>
     * 
     * @parameter {DtoStyleControllerOptions['findComplexBooks']} options
     * - name 可选查询参数，
     *      {@code null} 或 {@code ""} 将被忽略
     * @return 图书对象列表，每个对象包含所有标量属性、关联的
     *      {@link BookStore} 和关联的 {@link Author} 对象。
     */
    readonly findComplexBooks: (options: DtoStyleControllerOptions['findComplexBooks']) => Promise<
        ReadonlyArray<ComplexBookView>
    > = async(options) => {
        let _uri = '/dto/books/complex';
        let _separator = _uri.indexOf('?') === -1 ? '?' : '&';
        let _value: any = undefined;
        _value = options.name;
        if (_value !== undefined && _value !== null) {
            _uri += _separator
            _uri += 'name='
            _uri += encodeURIComponent(_value);
            _separator = '&';
        }
        return (await this.executor({uri: _uri, method: 'GET'})) as Promise<ReadonlyArray<ComplexBookView>>;
    }
    
    /**
     * 查询根树节点，即 parentId 为 null 的节点。
     * 
     * @return 所有根树节点的列表，每个节点包含所有标量属性和关联的子对象。
     *         如果子节点有更深层次的子节点，将递归关联直到没有更深层次的子节点为止。
     */
    readonly findRecursiveTreeNodes: () => Promise<
        ReadonlyArray<RecursiveTreeNodeView>
    > = async() => {
        let _uri = '/dto/rootTreeNodes/recursive';
        return (await this.executor({uri: _uri, method: 'GET'})) as Promise<ReadonlyArray<RecursiveTreeNodeView>>;
    }
    
    /**
     * 查询简单的图书对象。
     * 
     * <p>如果指定了此参数，则仅查询名称与指定名称匹配的图书。</p>
     * 
     * @parameter {DtoStyleControllerOptions['findSimpleBooks']} options
     * - name 可选查询参数，
     *      {@code null} 或 {@code ""} 将被忽略
     * @return 图书对象列表，每个对象仅包含 {@code id} 和 {@code name} 属性
     */
    readonly findSimpleBooks: (options: DtoStyleControllerOptions['findSimpleBooks']) => Promise<
        ReadonlyArray<SimpleBookView>
    > = async(options) => {
        let _uri = '/dto/books/simple';
        let _separator = _uri.indexOf('?') === -1 ? '?' : '&';
        let _value: any = undefined;
        _value = options.name;
        if (_value !== undefined && _value !== null) {
            _uri += _separator
            _uri += 'name='
            _uri += encodeURIComponent(_value);
            _separator = '&';
        }
        return (await this.executor({uri: _uri, method: 'GET'})) as Promise<ReadonlyArray<SimpleBookView>>;
    }
    
    /**
     * 查询根树节点，即 parentId 为 null 的节点。
     * 
     * @return 所有根树节点的列表，每个节点仅包含 {@code id} 和 {@code name} 属性
     */
    readonly findSimpleTreeNodes: () => Promise<
        ReadonlyArray<SimpleTreeNodeView>
    > = async() => {
        let _uri = '/dto/rootTreeNodes/simple';
        return (await this.executor({uri: _uri, method: 'GET'})) as Promise<ReadonlyArray<SimpleTreeNodeView>>;
    }
}

export type DtoStyleControllerOptions = {
    'findSimpleBooks': {
        /**
         * 可选查询参数，
         *      {@code null} 或 {@code ""} 将被忽略
         */
        readonly name?: string | undefined
    }, 
    'findComplexBooks': {
        /**
         * 可选查询参数，
         *      {@code null} 或 {@code ""} 将被忽略
         */
        readonly name?: string | undefined
    }, 
    'findSimpleTreeNodes': {}, 
    'findRecursiveTreeNodes': {}
}
