//
//  ViewController.swift
//  BokuNoHeroAcademiaMultiplatform
//
//  Created by Corrado Quattrocchi on 11/06/2020.
//  Copyright © 2020 Corrado Quattrocchi. All rights reserved.
//

import UIKit
import shared

class ViewController: UIViewController {
    
    private let koiniOS = KoiniOS()
    lazy var animeCharacterModel: NativeAnimeCharacterModel = NativeAnimeCharacterModel(
        viewUpdate: { [weak self] characters in
            self?.viewUpdate(characters: characters)
        }, errorUpdate: { [weak self] errorMessage in
            self?.errorUpdate(error: errorMessage)
        }
    )
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.animeCharacterModel.getCharactersList()

        syncDown()
    }
    
    private func syncDown() {
        self.animeCharacterModel.syncDown()
    }
    
    private func viewUpdate(characters: [BNHACharacterResponse]) {
        characters.forEach { [weak self] el in
            print(el.id, el.name, el.category, el.characterClass, el.quirk)
        }
    }
    
    private func errorUpdate(error: String) {
        print(error)
    }
    

}

