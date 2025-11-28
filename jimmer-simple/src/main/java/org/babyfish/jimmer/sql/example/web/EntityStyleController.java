package org.babyfish.jimmer.sql.example.web;

import org.babyfish.jimmer.client.FetchBy;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.example.model.*;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.jetbrains.annotations.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entity")
@Transactional
public class EntityStyleController implements Tables, Fetchers {

    private final JSqlClient sqlClient;

    public EntityStyleController(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    /**
     * 查询简单的图书对象。
     *
     * <p>如果指定了此参数，则仅查询名称与指定名称匹配的图书。</p>
     *
     * @param name 可选查询参数，
     *      {@code null} 或 {@code ""} 将被忽略
     * @return 图书对象列表，每个对象仅包含 {@code id} 和 {@code name} 属性
     */
    @GetMapping("/books/simple")
    public List<@FetchBy("SIMPLE_BOOK") Book> findSimpleBooks(
            @Nullable @RequestParam(required = false) String name
    ) {
        BookTable table = BOOK_TABLE;
        return sqlClient.createQuery(table)
                .where(table.name().eqIf(name))
                .select(table.fetch(SIMPLE_BOOK))
                .execute();
    }

    /**
     * 查询复杂的图书对象。
     *
     * <p>如果指定了此参数，则仅查询名称与指定名称匹配的图书。</p>
     *
     * @param name 可选查询参数，
     *      {@code null} 或 {@code ""} 将被忽略
     * @return 图书对象列表，每个对象包含所有标量属性、关联的
     *      {@link BookStore} 和关联的 {@link Author} 对象。
     */
    @GetMapping("/books/complex")
    public List<@FetchBy("COMPLEX_BOOK") Book> findComplexBooks(
            @Nullable @RequestParam(required = false) String name
    ) {
        BookTable table = BOOK_TABLE;
        return sqlClient.createQuery(table)
                .where(table.name().eqIf(name))
                .select(table.fetch(COMPLEX_BOOK))
                .execute();
    }

    /**
     * 查询根树节点，即 parentId 为 null 的节点。
     *
     * @return 所有根树节点的列表，每个节点仅包含 {@code id} 和 {@code name} 属性
     */
    @GetMapping("/rootTreeNodes/simple")
    public List<@FetchBy("SIMPLE_TREE_NODE") TreeNode> findSimpleTreeNodes() {
        TreeNodeTable table = TREE_NODE_TABLE;
        return sqlClient.createQuery(table)
                .where(table.parentId().isNull())
                .select(table.fetch(SIMPLE_TREE_NODE))
                .execute();
    }

    /**
     * 查询根树节点，即 parentId 为 null 的节点。
     *
     * @return 所有根树节点的列表，每个节点包含所有标量属性和关联的子对象。
     *         如果子节点有更深层次的子节点，将递归关联直到没有更深层次的子节点为止。
     */
    @GetMapping("/rootTreeNodes/recursive")
    public List<@FetchBy("RECURSIVE_TREE_NODE") TreeNode> findRecursiveTreeNodes() {
        TreeNodeTable table = TREE_NODE_TABLE;
        return sqlClient.createQuery(table)
                .where(table.parentId().isNull())
                .select(table.fetch(RECURSIVE_TREE_NODE))
                .execute();
    }

    /**
     * 由 ObjectFetcher 定义的简单图书 DTO
     */
    private static final Fetcher<Book> SIMPLE_BOOK =
            BOOK_FETCHER
                    .name();

    /**
     * 由 ObjectFetcher 定义的复杂图书 DTO
     */
    private static final Fetcher<Book> COMPLEX_BOOK =
            BOOK_FETCHER
                    .allScalarFields()
                    .store(
                            BOOK_STORE_FETCHER
                                    .allScalarFields()
                    )
                    .authors(
                            AUTHOR_FETCHER
                                    .allScalarFields()
                    );

    /**
     * 由 ObjectFetcher 定义的简单树节点 DTO
     */
    private static final Fetcher<TreeNode> SIMPLE_TREE_NODE =
            TREE_NODE_FETCHER
                    .name();

    /**
     * 由 ObjectFetcher 定义的递归树节点
     */
    private static final Fetcher<TreeNode> RECURSIVE_TREE_NODE =
            TREE_NODE_FETCHER
                    .allScalarFields()
                    .recursiveChildNodes();
}
