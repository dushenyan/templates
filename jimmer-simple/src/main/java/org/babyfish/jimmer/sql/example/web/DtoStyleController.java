package org.babyfish.jimmer.sql.example.web;

import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.example.model.*;
import org.babyfish.jimmer.sql.example.model.dto.ComplexBookView;
import org.babyfish.jimmer.sql.example.model.dto.RecursiveTreeNodeView;
import org.babyfish.jimmer.sql.example.model.dto.SimpleBookView;
import org.babyfish.jimmer.sql.example.model.dto.SimpleTreeNodeView;
import org.jetbrains.annotations.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dto")
@Transactional
public class DtoStyleController implements Tables {

    private final JSqlClient sqlClient;

    public DtoStyleController(JSqlClient sqlClient) {
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
    public List<SimpleBookView> findSimpleBooks(
            @Nullable @RequestParam(required = false) String name
    ) {
        BookTable table = BOOK_TABLE;
        return sqlClient.createQuery(table)
                .where(table.name().eqIf(name))
                .select(table.fetch(SimpleBookView.class))
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
    public List<ComplexBookView> findComplexBooks(
            @Nullable @RequestParam(required = false) String name
    ) {
        BookTable table = BOOK_TABLE;
        return sqlClient.createQuery(table)
                .where(table.name().eqIf(name))
                .select(table.fetch(ComplexBookView.class))
                .execute();
    }

    /**
     * 查询根树节点，即 parentId 为 null 的节点。
     *
     * @return 所有根树节点的列表，每个节点仅包含 {@code id} 和 {@code name} 属性
     */
    @GetMapping("/rootTreeNodes/simple")
    public List<SimpleTreeNodeView> findSimpleTreeNodes() {
        TreeNodeTable table = TREE_NODE_TABLE;
        return sqlClient.createQuery(table)
                .where(table.parentId().isNull())
                .select(table.fetch(SimpleTreeNodeView.class))
                .execute();
    }

    /**
     * 查询根树节点，即 parentId 为 null 的节点。
     *
     * @return 所有根树节点的列表，每个节点包含所有标量属性和关联的子对象。
     *         如果子节点有更深层次的子节点，将递归关联直到没有更深层次的子节点为止。
     */
    @GetMapping("/rootTreeNodes/recursive")
    public List<RecursiveTreeNodeView> findRecursiveTreeNodes() {
        TreeNodeTable table = TREE_NODE_TABLE;
        return sqlClient.createQuery(table)
                .where(table.parentId().isNull())
                .select(table.fetch(RecursiveTreeNodeView.class))
                .execute();
    }
}
