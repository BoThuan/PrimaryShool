PGDMP     5    !             
    y            primaryschool    14.0    14.0 
               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    30160    primaryschool    DATABASE     q   CREATE DATABASE primaryschool WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE primaryschool;
                postgres    false            �            1259    30511    tbl_students    TABLE       CREATE TABLE public.tbl_students (
    mahs character varying(255) NOT NULL,
    dia_chi character varying(255),
    ghi_chu character varying(255),
    gioi_tinh boolean,
    ngay_sinh timestamp without time zone,
    tenhs character varying(255),
    maph character varying(255),
    mapl character varying(255),
    makq character varying(255),
    hinh character varying(255)
);
     DROP TABLE public.tbl_students;
       public         heap    postgres    false            	          0    30511    tbl_students 
   TABLE DATA           s   COPY public.tbl_students (mahs, dia_chi, ghi_chu, gioi_tinh, ngay_sinh, tenhs, maph, mapl, makq, hinh) FROM stdin;
    public          postgres    false    217   l       z           2606    30547    tbl_students tbl_students_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT tbl_students_pkey PRIMARY KEY (mahs);
 H   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT tbl_students_pkey;
       public            postgres    false    217            {           2606    30556 (   tbl_students fk2asbbl0f2wks2u7av24fg34g2    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT fk2asbbl0f2wks2u7av24fg34g2 FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 R   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT fk2asbbl0f2wks2u7av24fg34g2;
       public          postgres    false    217            |           2606    30576 (   tbl_students fk9eijv8weg8w3y5igkgvdvkpup    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT fk9eijv8weg8w3y5igkgvdvkpup FOREIGN KEY (maph) REFERENCES public.tbl_parents(maph);
 R   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT fk9eijv8weg8w3y5igkgvdvkpup;
       public          postgres    false    217            }           2606    30637 (   tbl_students fkful1l6t2588cc7wm6c9gbucs3    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT fkful1l6t2588cc7wm6c9gbucs3 FOREIGN KEY (makq) REFERENCES public.tbl_results(makq);
 R   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT fkful1l6t2588cc7wm6c9gbucs3;
       public          postgres    false    217            	   7  x����J�@�ד��/���I�ΕK(4t�M(�����Gp-��� ����ح�2!�1oҙIM
ѕ00��wν7c�	���"�����!Z �	��o0>1E�j[mD
�U�VWT�\j�hh0��V���}��&�Pp�m��bvlB[p�P>*-o���!BEKD͍f2_��̾��|� RV�'p#�W�&�: ����ODZ[��s{�J2� =�)̹`0e�[�� ��������1i��T�M���'5[��St]��c�T���*Vp�x��N��H�o�C.d����{r��q��,�����(     