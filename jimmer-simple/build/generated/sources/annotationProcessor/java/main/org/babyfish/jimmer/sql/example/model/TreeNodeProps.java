package org.babyfish.jimmer.sql.example.model;

import java.lang.Long;
import java.lang.String;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.Selection;
import org.babyfish.jimmer.sql.ast.table.Props;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = TreeNode.class
)
@PropsFor(TreeNode.class)
public interface TreeNodeProps extends Props, Selection<TreeNode> {
    TypedProp.Scalar<TreeNode, Long> ID = 
        TypedProp.scalar(ImmutableType.get(TreeNode.class).getProp("id"));

    TypedProp.Scalar<TreeNode, String> NAME = 
        TypedProp.scalar(ImmutableType.get(TreeNode.class).getProp("name"));

    TypedProp.Reference<TreeNode, TreeNode> PARENT = 
        TypedProp.reference(ImmutableType.get(TreeNode.class).getProp("parent"));

    TypedProp.ReferenceList<TreeNode, TreeNode> CHILD_NODES = 
        TypedProp.referenceList(ImmutableType.get(TreeNode.class).getProp("childNodes"));

    PropExpression.Num<Long> id();

    PropExpression.Str name();

    TreeNodeTable parent();

    TreeNodeTable parent(JoinType joinType);

    PropExpression.Num<Long> parentId();

    Predicate childNodes(Function<TreeNodeTableEx, Predicate> block);
}
