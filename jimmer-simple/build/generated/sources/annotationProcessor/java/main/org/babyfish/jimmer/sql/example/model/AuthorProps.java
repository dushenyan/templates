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
        type = Author.class
)
@PropsFor(Author.class)
public interface AuthorProps extends Props, Selection<Author> {
    TypedProp.Scalar<Author, Long> ID = 
        TypedProp.scalar(ImmutableType.get(Author.class).getProp("id"));

    TypedProp.Scalar<Author, String> FIRST_NAME = 
        TypedProp.scalar(ImmutableType.get(Author.class).getProp("firstName"));

    TypedProp.Scalar<Author, String> LAST_NAME = 
        TypedProp.scalar(ImmutableType.get(Author.class).getProp("lastName"));

    TypedProp.Scalar<Author, Gender> GENDER = 
        TypedProp.scalar(ImmutableType.get(Author.class).getProp("gender"));

    TypedProp.ReferenceList<Author, Book> BOOKS = 
        TypedProp.referenceList(ImmutableType.get(Author.class).getProp("books"));

    PropExpression.Num<Long> id();

    PropExpression.Str firstName();

    PropExpression.Str lastName();

    PropExpression.Cmp<Gender> gender();

    Predicate books(Function<BookTableEx, Predicate> block);
}
