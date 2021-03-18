open Printf
open String
open List

type entry = 
    | File of string
    | Directory of string * entry list;;

let rec walk depth e =
    String.make depth '-' |> Printf.printf "%s";
    match e with
    | File name -> name |> Printf.printf "%s\n"
    | Directory (name, children) -> (
        name |> Printf.printf "%s\n";
        children |> List.map (walk (depth + 1)) |> ignore
    )


let () =
    let bin_dir = Directory ("bin", [File "vi"; File "latex"]) in
    let tmp_dir = Directory ("tmp", []) in
    let usr_dir = Directory ("usr", []) in
    let root_dir = Directory ("root", [bin_dir; tmp_dir; usr_dir]) in
    walk 0 root_dir