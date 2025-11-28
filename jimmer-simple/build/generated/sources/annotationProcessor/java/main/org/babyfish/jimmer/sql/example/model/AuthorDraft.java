package org.babyfish.jimmer.sql.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.lang.CloneNotSupportedException;
import java.lang.Cloneable;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.System;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.babyfish.jimmer.CircularReferenceException;
import org.babyfish.jimmer.Draft;
import org.babyfish.jimmer.DraftConsumer;
import org.babyfish.jimmer.ImmutableObjects;
import org.babyfish.jimmer.UnloadedException;
import org.babyfish.jimmer.client.Description;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.jackson.ImmutableModuleRequiredException;
import org.babyfish.jimmer.lang.OldChain;
import org.babyfish.jimmer.meta.ImmutablePropCategory;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.PropId;
import org.babyfish.jimmer.runtime.DraftContext;
import org.babyfish.jimmer.runtime.DraftSpi;
import org.babyfish.jimmer.runtime.ImmutableSpi;
import org.babyfish.jimmer.runtime.Internal;
import org.babyfish.jimmer.runtime.NonSharedList;
import org.babyfish.jimmer.runtime.Visibility;
import org.babyfish.jimmer.sql.ManyToMany;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

@GeneratedBy(
        type = Author.class
)
public interface AuthorDraft extends Author, Draft {
    AuthorDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    AuthorDraft setId(long id);

    @OldChain
    AuthorDraft setFirstName(String firstName);

    @OldChain
    AuthorDraft setLastName(String lastName);

    @OldChain
    AuthorDraft setGender(Gender gender);

    List<BookDraft> books(boolean autoCreate);

    @OldChain
    AuthorDraft setBooks(List<Book> books);

    @OldChain
    AuthorDraft addIntoBooks(DraftConsumer<BookDraft> block);

    @OldChain
    AuthorDraft addIntoBooks(Book base, DraftConsumer<BookDraft> block);

    @GeneratedBy(
            type = Author.class
    )
    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_ID = 0;

        public static final int SLOT_FIRST_NAME = 1;

        public static final int SLOT_LAST_NAME = 2;

        public static final int SLOT_GENDER = 3;

        public static final int SLOT_BOOKS = 4;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.9.114",
                Author.class,
                Collections.emptyList(),
                (ctx, base) -> new DraftImpl(ctx, (Author)base)
            )
            .id(SLOT_ID, "id", long.class)
            .key(SLOT_FIRST_NAME, "firstName", String.class, false)
            .key(SLOT_LAST_NAME, "lastName", String.class, false)
            .add(SLOT_GENDER, "gender", ImmutablePropCategory.SCALAR, Gender.class, false)
            .add(SLOT_BOOKS, "books", ManyToMany.class, Book.class, false)
            .build();

        private Producer() {
        }

        public Author produce(DraftConsumer<AuthorDraft> block) {
            return (Author)Internal.produce(TYPE, null, block);
        }

        public Author produce(Author base, DraftConsumer<AuthorDraft> block) {
            return (Author)Internal.produce(TYPE, base, block);
        }

        public Author produce(boolean resolveImmediately, DraftConsumer<AuthorDraft> block) {
            return (Author)Internal.produce(TYPE, null, resolveImmediately, block);
        }

        public Author produce(Author base, boolean resolveImmediately,
                DraftConsumer<AuthorDraft> block) {
            return (Author)Internal.produce(TYPE, base, resolveImmediately, block);
        }

        /**
         * Class, not interface, for free-marker
         */
        @GeneratedBy(
                type = Author.class
        )
        @JsonPropertyOrder({"dummyPropForJacksonError__", "id", "firstName", "lastName", "gender", "books"})
        public abstract static class Implementor implements Author, ImmutableSpi {
            @Override
            public final Object __get(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __get(prop.asName());
                    case SLOT_ID:
                    		return (Long)id();
                    case SLOT_FIRST_NAME:
                    		return firstName();
                    case SLOT_LAST_NAME:
                    		return lastName();
                    case SLOT_GENDER:
                    		return gender();
                    case SLOT_BOOKS:
                    		return books();
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Author\": \"" + prop + "\"");
                }
            }

            @Override
            public final Object __get(String prop) {
                switch (prop) {
                    case "id":
                    		return (Long)id();
                    case "firstName":
                    		return firstName();
                    case "lastName":
                    		return lastName();
                    case "gender":
                    		return gender();
                    case "books":
                    		return books();
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Author\": \"" + prop + "\"");
                }
            }

            public final long getId() {
                return id();
            }

            public final String getFirstName() {
                return firstName();
            }

            public final String getLastName() {
                return lastName();
            }

            public final Gender getGender() {
                return gender();
            }

            public final List<Book> getBooks() {
                return books();
            }

            @Override
            public final ImmutableType __type() {
                return TYPE;
            }

            public final int getDummyPropForJacksonError__() {
                throw new ImmutableModuleRequiredException();
            }
        }

        @GeneratedBy(
                type = Author.class
        )
        private static class Impl extends Implementor implements Cloneable, Serializable {
            private Visibility __visibility;

            long __idValue;

            boolean __idLoaded = false;

            String __firstNameValue;

            String __lastNameValue;

            Gender __genderValue;

            NonSharedList<Book> __booksValue;

            @Override
            @JsonIgnore
            @Description("The surrogate id of the current object,\n"
                            + "auto-incrementing,\n"
                            + "without specific business meaning")
            public long id() {
                if (!__idLoaded) {
                    throw new UnloadedException(Author.class, "id");
                }
                return __idValue;
            }

            @Override
            @JsonIgnore
            @Description("The first name of current Author.\n"
                            + "\n"
                            + "<p>This property forms a unique constraint together with\n"
                            + "the {@code lastName} property, which is {@code @Key} of Jimmer</p>")
            public String firstName() {
                if (__firstNameValue == null) {
                    throw new UnloadedException(Author.class, "firstName");
                }
                return __firstNameValue;
            }

            @Override
            @JsonIgnore
            @Description("The last name of current Book.\n"
                            + "\n"
                            + "<p>This property forms a unique constraint together with\n"
                            + "the {@code firstName} property, which is {@code @Key} of Jimmer</p>")
            public String lastName() {
                if (__lastNameValue == null) {
                    throw new UnloadedException(Author.class, "lastName");
                }
                return __lastNameValue;
            }

            @Override
            @JsonIgnore
            public Gender gender() {
                if (__genderValue == null) {
                    throw new UnloadedException(Author.class, "gender");
                }
                return __genderValue;
            }

            @Override
            @JsonIgnore
            public List<Book> books() {
                if (__booksValue == null) {
                    throw new UnloadedException(Author.class, "books");
                }
                return __booksValue;
            }

            @Override
            public Impl clone() {
                try {
                    Impl copy = (Impl) super.clone();
                    Visibility originalVisibility = this.__visibility;
                    if (originalVisibility != null) {
                        Visibility newVisibility = Visibility.of(5);
                        for (int propId = 0; propId < 5; propId++) {
                            newVisibility.show(propId, originalVisibility.visible(propId));
                        }
                        copy.__visibility = newVisibility;
                    } else {
                        copy.__visibility = null;
                    }
                    return copy;
                } catch(CloneNotSupportedException ex) {
                    throw new AssertionError(ex);
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isLoaded(prop.asName());
                    case SLOT_ID:
                    		return __idLoaded;
                    case SLOT_FIRST_NAME:
                    		return __firstNameValue != null;
                    case SLOT_LAST_NAME:
                    		return __lastNameValue != null;
                    case SLOT_GENDER:
                    		return __genderValue != null;
                    case SLOT_BOOKS:
                    		return __booksValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Author\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isLoaded(String prop) {
                switch (prop) {
                    case "id":
                    		return __idLoaded;
                    case "firstName":
                    		return __firstNameValue != null;
                    case "lastName":
                    		return __lastNameValue != null;
                    case "gender":
                    		return __genderValue != null;
                    case "books":
                    		return __booksValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Author\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isVisible(PropId prop) {
                if (__visibility == null) {
                    return true;
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isVisible(prop.asName());
                    case SLOT_ID:
                    		return __visibility.visible(SLOT_ID);
                    case SLOT_FIRST_NAME:
                    		return __visibility.visible(SLOT_FIRST_NAME);
                    case SLOT_LAST_NAME:
                    		return __visibility.visible(SLOT_LAST_NAME);
                    case SLOT_GENDER:
                    		return __visibility.visible(SLOT_GENDER);
                    case SLOT_BOOKS:
                    		return __visibility.visible(SLOT_BOOKS);
                    default: return true;
                }
            }

            @Override
            public boolean __isVisible(String prop) {
                if (__visibility == null) {
                    return true;
                }
                switch (prop) {
                    case "id":
                    		return __visibility.visible(SLOT_ID);
                    case "firstName":
                    		return __visibility.visible(SLOT_FIRST_NAME);
                    case "lastName":
                    		return __visibility.visible(SLOT_LAST_NAME);
                    case "gender":
                    		return __visibility.visible(SLOT_GENDER);
                    case "books":
                    		return __visibility.visible(SLOT_BOOKS);
                    default: return true;
                }
            }

            @Override
            public int hashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                    // If entity-id is loaded, return directly
                    return hash;
                }
                if (__firstNameValue != null) {
                    hash = 31 * hash + __firstNameValue.hashCode();
                }
                if (__lastNameValue != null) {
                    hash = 31 * hash + __lastNameValue.hashCode();
                }
                if (__genderValue != null) {
                    hash = 31 * hash + __genderValue.hashCode();
                }
                if (__booksValue != null) {
                    hash = 31 * hash + __booksValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                }
                if (__firstNameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__firstNameValue);
                }
                if (__lastNameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__lastNameValue);
                }
                if (__genderValue != null) {
                    hash = 31 * hash + System.identityHashCode(__genderValue);
                }
                if (__booksValue != null) {
                    hash = 31 * hash + System.identityHashCode(__booksValue);
                }
                return hash;
            }

            @Override
            public int __hashCode(boolean shallow) {
                return shallow ? __shallowHashCode() : hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded) {
                    // If entity-id is loaded, return directly
                    return __idValue == __other.id();
                }
                if (__isVisible(PropId.byIndex(SLOT_FIRST_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_FIRST_NAME))) {
                    return false;
                }
                boolean __firstNameLoaded = __firstNameValue != null;
                if (__firstNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_FIRST_NAME))) {
                    return false;
                }
                if (__firstNameLoaded && !Objects.equals(__firstNameValue, __other.firstName())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_LAST_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_LAST_NAME))) {
                    return false;
                }
                boolean __lastNameLoaded = __lastNameValue != null;
                if (__lastNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_LAST_NAME))) {
                    return false;
                }
                if (__lastNameLoaded && !Objects.equals(__lastNameValue, __other.lastName())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_GENDER)) != __other.__isVisible(PropId.byIndex(SLOT_GENDER))) {
                    return false;
                }
                boolean __genderLoaded = __genderValue != null;
                if (__genderLoaded != __other.__isLoaded(PropId.byIndex(SLOT_GENDER))) {
                    return false;
                }
                if (__genderLoaded && !Objects.equals(__genderValue, __other.gender())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_BOOKS)) != __other.__isVisible(PropId.byIndex(SLOT_BOOKS))) {
                    return false;
                }
                boolean __booksLoaded = __booksValue != null;
                if (__booksLoaded != __other.__isLoaded(PropId.byIndex(SLOT_BOOKS))) {
                    return false;
                }
                if (__booksLoaded && !Objects.equals(__booksValue, __other.books())) {
                    return false;
                }
                return true;
            }

            private boolean __shallowEquals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded && __idValue != __other.id()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_FIRST_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_FIRST_NAME))) {
                    return false;
                }
                boolean __firstNameLoaded = __firstNameValue != null;
                if (__firstNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_FIRST_NAME))) {
                    return false;
                }
                if (__firstNameLoaded && __firstNameValue != __other.firstName()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_LAST_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_LAST_NAME))) {
                    return false;
                }
                boolean __lastNameLoaded = __lastNameValue != null;
                if (__lastNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_LAST_NAME))) {
                    return false;
                }
                if (__lastNameLoaded && __lastNameValue != __other.lastName()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_GENDER)) != __other.__isVisible(PropId.byIndex(SLOT_GENDER))) {
                    return false;
                }
                boolean __genderLoaded = __genderValue != null;
                if (__genderLoaded != __other.__isLoaded(PropId.byIndex(SLOT_GENDER))) {
                    return false;
                }
                if (__genderLoaded && __genderValue != __other.gender()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_BOOKS)) != __other.__isVisible(PropId.byIndex(SLOT_BOOKS))) {
                    return false;
                }
                boolean __booksLoaded = __booksValue != null;
                if (__booksLoaded != __other.__isLoaded(PropId.byIndex(SLOT_BOOKS))) {
                    return false;
                }
                if (__booksLoaded && __booksValue != __other.books()) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return shallow ? __shallowEquals(obj) : equals(obj);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }
        }

        @GeneratedBy(
                type = Author.class
        )
        private static class DraftImpl extends Implementor implements DraftSpi, AuthorDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            private Author __resolved;

            DraftImpl(DraftContext ctx, Author base) {
                __ctx = ctx;
                if (base != null) {
                    __base = (Impl)base;
                }
                else {
                    __modified = new Impl();
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isLoaded(String prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isVisible(PropId prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public boolean __isVisible(String prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public int hashCode() {
                return (__modified!= null ? __modified : __base).hashCode();
            }

            @Override
            public int __hashCode(boolean shallow) {
                return (__modified!= null ? __modified : __base).__hashCode(shallow);
            }

            @Override
            public boolean equals(Object obj) {
                return (__modified!= null ? __modified : __base).equals(obj);
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return (__modified!= null ? __modified : __base).__equals(obj, shallow);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }

            @Override
            @JsonIgnore
            public long id() {
                return (__modified!= null ? __modified : __base).id();
            }

            @Override
            public AuthorDraft setId(long id) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__idValue = id;
                __tmpModified.__idLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public String firstName() {
                return (__modified!= null ? __modified : __base).firstName();
            }

            @Override
            public AuthorDraft setFirstName(String firstName) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (firstName == null) {
                    throw new IllegalArgumentException(
                        "'firstName' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__firstNameValue = firstName;
                return this;
            }

            @Override
            @JsonIgnore
            public String lastName() {
                return (__modified!= null ? __modified : __base).lastName();
            }

            @Override
            public AuthorDraft setLastName(String lastName) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (lastName == null) {
                    throw new IllegalArgumentException(
                        "'lastName' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__lastNameValue = lastName;
                return this;
            }

            @Override
            @JsonIgnore
            public Gender gender() {
                return (__modified!= null ? __modified : __base).gender();
            }

            @Override
            public AuthorDraft setGender(Gender gender) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (gender == null) {
                    throw new IllegalArgumentException(
                        "'gender' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__genderValue = gender;
                return this;
            }

            @Override
            @JsonIgnore
            public List<Book> books() {
                return __ctx.toDraftList((__modified!= null ? __modified : __base).books(), Book.class, true);
            }

            @Override
            public List<BookDraft> books(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_BOOKS)))) {
                    setBooks(new ArrayList<>());
                }
                return __ctx.toDraftList((__modified!= null ? __modified : __base).books(), Book.class, true);
            }

            @Override
            public AuthorDraft setBooks(List<Book> books) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (books == null) {
                    throw new IllegalArgumentException(
                        "'books' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__booksValue = NonSharedList.of(__tmpModified.__booksValue, books);
                return this;
            }

            @Override
            public AuthorDraft addIntoBooks(DraftConsumer<BookDraft> block) {
                addIntoBooks(null, block);
                return this;
            }

            @Override
            public AuthorDraft addIntoBooks(Book base, DraftConsumer<BookDraft> block) {
                books(true).add((BookDraft)BookDraft.$.produce(base, block));
                return this;
            }

            @SuppressWarnings("all")
            @Override
            public void __set(PropId prop, Object value) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__set(prop.asName(), value);
                    return;
                    case SLOT_ID:
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case SLOT_FIRST_NAME:
                    		setFirstName((String)value);break;
                    case SLOT_LAST_NAME:
                    		setLastName((String)value);break;
                    case SLOT_GENDER:
                    		setGender((Gender)value);break;
                    case SLOT_BOOKS:
                    		setBooks((List<Book>)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"org.babyfish.jimmer.sql.example.model.Author\": \"" + prop + "\"");
                }
            }

            @SuppressWarnings("all")
            @Override
            public void __set(String prop, Object value) {
                switch (prop) {
                    case "id":
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case "firstName":
                    		setFirstName((String)value);break;
                    case "lastName":
                    		setLastName((String)value);break;
                    case "gender":
                    		setGender((Gender)value);break;
                    case "books":
                    		setBooks((List<Book>)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Author\": \"" + prop + "\"");
                }
            }

            @Override
            public void __show(PropId prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(5);
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__show(prop.asName(), visible);
                    return;
                    case SLOT_ID:
                    		__visibility.show(SLOT_ID, visible);break;
                    case SLOT_FIRST_NAME:
                    		__visibility.show(SLOT_FIRST_NAME, visible);break;
                    case SLOT_LAST_NAME:
                    		__visibility.show(SLOT_LAST_NAME, visible);break;
                    case SLOT_GENDER:
                    		__visibility.show(SLOT_GENDER, visible);break;
                    case SLOT_BOOKS:
                    		__visibility.show(SLOT_BOOKS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"org.babyfish.jimmer.sql.example.model.Author\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __show(String prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(5);
                }
                switch (prop) {
                    case "id":
                    		__visibility.show(SLOT_ID, visible);break;
                    case "firstName":
                    		__visibility.show(SLOT_FIRST_NAME, visible);break;
                    case "lastName":
                    		__visibility.show(SLOT_LAST_NAME, visible);break;
                    case "gender":
                    		__visibility.show(SLOT_GENDER, visible);break;
                    case "books":
                    		__visibility.show(SLOT_BOOKS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"org.babyfish.jimmer.sql.example.model.Author\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __unload(PropId prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__unload(prop.asName());
                    return;
                    case SLOT_ID:
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case SLOT_FIRST_NAME:
                    		__modified().__firstNameValue = null;break;
                    case SLOT_LAST_NAME:
                    		__modified().__lastNameValue = null;break;
                    case SLOT_GENDER:
                    		__modified().__genderValue = null;break;
                    case SLOT_BOOKS:
                    		__modified().__booksValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"org.babyfish.jimmer.sql.example.model.Author\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public void __unload(String prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                switch (prop) {
                    case "id":
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case "firstName":
                    		__modified().__firstNameValue = null;break;
                    case "lastName":
                    		__modified().__lastNameValue = null;break;
                    case "gender":
                    		__modified().__genderValue = null;break;
                    case "books":
                    		__modified().__booksValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Author\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public DraftContext __draftContext() {
                return __ctx;
            }

            @Override
            public Object __resolve() {
                if (__resolved != null) {
                    return __resolved;
                }
                if (__resolving) {
                    throw new CircularReferenceException();
                }
                __resolving = true;
                try {
                    Implementor base = __base;
                    Impl __tmpModified = __modified;
                    if (__tmpModified == null) {
                        if (base.__isLoaded(PropId.byIndex(SLOT_BOOKS))) {
                            List<Book> oldValue = base.books();
                            List<Book> newValue = __ctx.resolveList(oldValue);
                            if (oldValue != newValue) {
                                setBooks(newValue);
                            }
                        }
                        __tmpModified = __modified;
                    }
                    else {
                        __tmpModified.__booksValue = NonSharedList.of(__tmpModified.__booksValue, __ctx.resolveList(__tmpModified.__booksValue));
                    }
                    if (__base != null && __tmpModified == null) {
                        this.__resolved = base;
                        return base;
                    }
                    this.__resolved = __tmpModified;
                    return __tmpModified;
                }
                finally {
                    __resolving = false;
                }
            }

            @Override
            public boolean __isResolved() {
                return __resolved != null;
            }

            Impl __modified() {
                Impl __tmpModified = __modified;
                if (__tmpModified == null) {
                    __tmpModified = __base.clone();
                    __modified = __tmpModified;
                }
                return __tmpModified;
            }
        }
    }

    @GeneratedBy(
            type = Author.class
    )
    class Builder {
        private final Producer.DraftImpl __draft;

        public Builder() {
            this(null);
        }

        public Builder(@Nullable Author base) {
            __draft = new Producer.DraftImpl(null, base);
        }

        public Builder id(@NonNull Long id) {
            if (id != null) {
                __draft.setId(id);
            }
            return this;
        }

        public Builder firstName(@NonNull String firstName) {
            if (firstName != null) {
                __draft.setFirstName(firstName);
            }
            return this;
        }

        public Builder lastName(@NonNull String lastName) {
            if (lastName != null) {
                __draft.setLastName(lastName);
            }
            return this;
        }

        public Builder gender(@NonNull Gender gender) {
            if (gender != null) {
                __draft.setGender(gender);
            }
            return this;
        }

        public Builder books(@NonNull List<Book> books) {
            if (books != null) {
                __draft.setBooks(books);
            }
            return this;
        }

        public Author build() {
            return (Author)__draft.__modified();
        }
    }
}
