package org.babyfish.jimmer.sql.example.model;

import java.lang.Long;
import java.lang.String;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.Selection;
import org.babyfish.jimmer.sql.ast.table.Props;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = BookStore.class
)
@PropsFor(BookStore.class)
public interface BookStoreProps extends Props, Selection<BookStore> {
    TypedProp.Scalar<BookStore, Long> ID = 
        TypedProp.scalar(ImmutableType.get(BookStore.class).getProp("id"));

    TypedProp.Scalar<BookStore, String> NAME = 
        TypedProp.scalar(ImmutableType.get(BookStore.class).getProp("name"));

    TypedProp.Scalar<BookStore, String> WEBSITE = 
        TypedProp.scalar(ImmutableType.get(BookStore.class).getProp("website"));

    TypedProp.ReferenceList<BookStore, Book> BOOKS = 
        TypedProp.referenceList(ImmutableType.get(BookStore.class).getProp("books"));

    PropExpression.Num<Long> id();

    PropExpression.Str name();

    PropExpression.Str website();

    Predicate books(Function<BookTableEx, Predicate> block);
}
